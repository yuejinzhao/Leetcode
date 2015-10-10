wordPattern = (pattern, str) ->
    arr = str.split(' ')
    result = true

    hashMap = (char, string) ->
        hashTable = {}
        current = 0

        while current < arr.length
            if hashTable[char[current]] == undefined
                hashTable[char[current]] = string[current]
            else
                if hashTable[char[current]] != string[current]
                    return false
            current++
        return true
        
    if pattern.length != str.length
        return false
    else
        result = hashMap(pattern, arr)
    return result
