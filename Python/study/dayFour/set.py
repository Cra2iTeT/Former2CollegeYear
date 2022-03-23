"""
@Project ：study 
@File    ：set.py
@IDE     ：PyCharm 
@Author  ：Cra2iTeT
@Date    ：2022/3/21 14:27 
"""
# s1 = {100}
# print(s1)
# print(type(s1))
# s1.add(20)
# print(s1)
# s1.update([30,40])
# print(s1)

# s2 = {10,20,3,4,5,6}
# print(s2)
#
# s2.pop()
# print(s2)

# s3 = {10, 20, 3, 4, 5, 6}
# print(30 in s3)

# dict1 = {'name': "Cra2iTeT", "age": 20}
# del dict1['name']
# print(dict1)
# del (dict1['name'])
# print(dict1)

# for i in range(1,10,1):     # 不输出终止
#     print(i,end="\t")
#
# print()
#
# for i in range(1,10):       # 默认步长1
#     print(i,end="\t")
#
# print()
#
# for i in range(10):     # 默认从0开始，步长1
#     print(i,end="\t")

# list1 = [1,2,3,4,5]
# for i in enumerate(list1):
#     print(i)
# for i in enumerate(list1,start=1):      # 不改变开始下标，但是显示会以参数开始
#     print(i)

# list1 = [i for i in range(10)]
# print(list1)

# set = {i for i in range(10)}
# print(set)

# list1 = [i for i in range(10) if i % 2 == 0]
# print(list1)

# list1 = [(i,j) for i in range(3) for j in range(3)]
# print(list1)

# list1 = ['name', 'age', 'gender']
# list2 = ['Cra2iTeT', 20, '男']
# list3 = ['Cra2iTeT',20,'男',110]
# dict1 = {list1[i]: list2[i] for i in range(len(list1))}
# dict1 = {list1[i]: list3[i] for i in range(len(list1))}
# dict1 = {list1[i]: list3[i] for i in range(len(list3))}     # 数据个数不一样选择多的会报错
# print(dict1)

# def fun(a,b):
#     '''
#
#     :param a:
#     :param b:
#     :return:
#     '''