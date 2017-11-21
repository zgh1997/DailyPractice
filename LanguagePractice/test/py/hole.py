
def trans_num(num):
    x = [int(num / 10**i) % 10 for i in range(4)]
    x.sort();
    return(sum([(10**i) * x[i] for i in range(4)]),sum([(10**(3 - i)) * x[i] for i in range(4)]))
def find_hole(num):
    x,y = trans_num(num)
    if x != y:
        while (x - y) != 6174:
            print(" ->",x,"-",y,"=",x - y);
            (x,y) = trans_num(x - y);
        print(" ->",x,"-",y,"=",x - y);
    else:
        print(num);
for i in range(10000)[1:10000]:
    find_hole(i)
