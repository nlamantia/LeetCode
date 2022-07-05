# @param {String} s
# @return {Boolean}
def is_palindrome(s)
    s = s.downcase.gsub(%r{[^a-z0-9]}, '')
    ptr1, ptr2 = [0, s.length - 1]
    until ptr1 >= ptr2
        return false unless s[ptr1] == s[ptr2]
        ptr1 += 1
        ptr2 -= 1
    end
    true
end