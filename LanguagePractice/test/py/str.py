words = ['abcdef', 'abcw', 'bar', 'baz', 'foo', 'xtfn']
words.sort(key = lambda x:len(x))
max = 0
strlen = len(words)
bools = [[True for i in range(strlen)] for j in range(strlen)]
alpha = [chr(i + 97) for i in range(26)]
alphaArray = [[alpha[j] in words[i] for i in range(strlen)] for j in range(26)]
for i in range(26):
    for x in range(strlen):
        for y in range(strlen):
            if alphaArray[i][x] & alphaArray[i][y]:
                bools[x][y] = False
                bools[y][x] = False
for x1 in range(strlen):
    for x2 in range(strlen):
        if bools[x1][x2]:
            if len(words[x1])*len(words[x2]) > max:
                max = len(words[x1])*len(words[x2])
if max == 0:
    print("No such pair of words")
else:
    print(max)
print(bools)
