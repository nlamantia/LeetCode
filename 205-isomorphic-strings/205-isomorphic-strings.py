class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        sChars, tChars = {}, {}
        for i in range(len(s)):
            if s[i] in sChars:
                if sChars[s[i]] != t[i]:
                    return False
            elif t[i] in tChars:
                return False
            else:
                sChars[s[i]] = t[i]
                tChars[t[i]] = s[i]
                
        return True