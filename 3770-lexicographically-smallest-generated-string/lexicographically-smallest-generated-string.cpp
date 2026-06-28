#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class Solution {
public:
    string generateString(string str1, string str2) {
        int n = str1.length();
        int m = str2.length();
        int L = n + m - 1;
        
        const long long M1 = 1e9 + 7, B1 = 313;
        const long long M2 = 1e9 + 9, B2 = 317;

        vector<long long> p1(L + 1, 1), p2(L + 1, 1);
        for (int i = 0; i < L; ++i) {
            p1[i + 1] = (p1[i] * B1) % M1;
            p2[i + 1] = (p2[i] * B2) % M2;
        }

        vector<long long> h1(m + 1, 0), h2(m + 1, 0);
        for (int i = 0; i < m; ++i) {
            h1[i + 1] = (h1[i] * B1 + str2[i]) % M1;
            h2[i + 1] = (h2[i] * B2 + str2[i]) % M2;
        }

        auto get_hash_str2 = [&](int l, int r) -> pair<long long, long long> {
            if (l > r) return {0, 0};
            long long res1 = (h1[r + 1] - h1[l] * p1[r - l + 1]) % M1;
            if (res1 < 0) res1 += M1;
            long long res2 = (h2[r + 1] - h2[l] * p2[r - l + 1]) % M2;
            if (res2 < 0) res2 += M2;
            return {res1, res2};
        };

        string word(L, '?');
        int last_t = -1;
        for (int i = 0; i < n; ++i) {
            if (str1[i] == 'T') {
                int start = max(i, last_t + 1);
                for (int j = start; j < i + m; ++j) {
                    word[j] = str2[j - i];
                }
                last_t = max(last_t, i + m - 1);
            }
        }

        vector<long long> wh1(L + 1, 0), wh2(L + 1, 0);
        for (int i = 0; i < L; ++i) {
            wh1[i + 1] = (wh1[i] * B1 + word[i]) % M1;
            wh2[i + 1] = (wh2[i] * B2 + word[i]) % M2;
        }

        auto get_hash_static_word = [&](int l, int r) -> pair<long long, long long> {
            if (l > r) return {0, 0};
            long long res1 = (wh1[r + 1] - wh1[l] * p1[r - l + 1]) % M1;
            if (res1 < 0) res1 += M1;
            long long res2 = (wh2[r + 1] - wh2[l] * p2[r - l + 1]) % M2;
            if (res2 < 0) res2 += M2;
            return {res1, res2};
        };

        for (int i = 0; i < n; ++i) {
            if (str1[i] == 'T') {
                if (get_hash_static_word(i, i + m - 1) != get_hash_str2(0, m - 1)) {
                    return "";
                }
            }
        }

        vector<int> qs;
        for (int i = 0; i < L; ++i) {
            if (word[i] == '?') qs.push_back(i);
        }

        vector<vector<int>> F_ends(L);
        for (int i = 0; i < n; ++i) {
            if (str1[i] == 'F') {
                auto it = upper_bound(qs.begin(), qs.end(), i + m - 1);
                int last_q_idx = -1;
                
                if (it != qs.begin()) {
                    --it;
                    if (*it >= i) last_q_idx = *it;
                }

                if (last_q_idx == -1) {
   
                    if (get_hash_static_word(i, i + m - 1) == get_hash_str2(0, m - 1)) return "";
                } else {
                    int k = last_q_idx;
                    int suff_len = (i + m - 1) - k;
                    if (suff_len == 0) {
                        F_ends[k].push_back(i);
                    } else {
  
                        if (get_hash_static_word(k + 1, i + m - 1) == get_hash_str2(k - i + 1, m - 1)) {
                            F_ends[k].push_back(i);
                        }
                    }
                }
            }
        }

        vector<long long> dyn_h1(L + 1, 0), dyn_h2(L + 1, 0);
        auto get_hash_dynamic_word = [&](int l, int r) -> pair<long long, long long> {
            if (l > r) return {0, 0};
            long long res1 = (dyn_h1[r + 1] - dyn_h1[l] * p1[r - l + 1]) % M1;
            if (res1 < 0) res1 += M1;
            long long res2 = (dyn_h2[r + 1] - dyn_h2[l] * p2[r - l + 1]) % M2;
            if (res2 < 0) res2 += M2;
            return {res1, res2};
        };

        for (int k = 0; k < L; ++k) {
            if (word[k] != '?') {
                dyn_h1[k + 1] = (dyn_h1[k] * B1 + word[k]) % M1;
                dyn_h2[k + 1] = (dyn_h2[k] * B2 + word[k]) % M2;
            } else {
                bool char_found = false;
                for (char c = 'a'; c <= 'z'; ++c) {
                    bool safe = true;
                    
                    for (int i : F_ends[k]) {
                        if (c == str2[k - i]) { 
                            int pref_len = k - i;
                            if (pref_len == 0) {
                                safe = false;
                                break;
                            } else {

                                if (get_hash_dynamic_word(i, k - 1) == get_hash_str2(0, k - i - 1)) {
                                    safe = false;
                                    break;
                                }
                            }
                        }
                    }
                    if (safe) {
                        word[k] = c;
                        dyn_h1[k + 1] = (dyn_h1[k] * B1 + c) % M1;
                        dyn_h2[k + 1] = (dyn_h2[k] * B2 + c) % M2;
                        char_found = true;
                        break;
                    }
                }
                if (!char_found) return "";
            }
        }
        
        return word;
    }
};