t = int(input())
for i in range(t):
    n = int(input())
    arr = [[0]*2 for _ in range(n)]
    for j in range(n):
        arr[j][0], arr[j][1] = map(int, input().split(" "))
    arr.sort(key=lambda x:x[1])
    endTime = 0
    count = 0
    for k in range(n):
        s = arr[k][0]
        e = arr[k][1]
        if s >= endTime:
            endTime = e
            count += 1
    print(count)
