"""
@Project ：study 
@File    ：else.py
@IDE     ：PyCharm 
@Author  ：Cra2iTeT
@Date    ：2022/3/19 16:29 
"""
# while

i = 0
while i < 5:
    print(i, end="\t")
    i += 1
else:
    print("这里是正常执行while的else")

i = 0
while i < 5:
    if i == 3:
        break
    print(i,end="\t")
    i += 1
else:
    print("这是break的while的else")

print()

leg = "Cra2iTeT"
for i in leg:
    if i == "2":
        continue
    print(i,end="\t")
else:
    print("这是continue for 的else")