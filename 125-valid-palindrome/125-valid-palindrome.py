class Solution:
    def isPalindrome(self, s: str) -> bool:
        def palindrome(s):
            start, end = 0, len(s) - 1
            while start < end:
                if s[start] != s[end]:
                    return False
                start += 1
                end -= 1
                
            return True
            
        return palindrome(re.sub(r'[^a-z0-9]', '', s.lower()))
        