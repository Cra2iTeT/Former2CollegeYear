"""
@Project ：study 
@File    ：__init__.py.py
@IDE     ：PyCharm 
@Author  ：Cra2iTeT
@Date    ：2022/3/22 8:40 
"""

# dict1  = {'name':"Cra2iTeT",'age':18}
# print(dict1)
# print(id(dict1))
# dict1["id"] = 20
# print(dict1)
# print(id(dict1))

# def test(a):
#     a += 1
#     print(a)
#
# b = 10
# print(id(b))
# print(b)
# test(b)
# print(id(b))
# print(b)

# def myfunc(n):
#     return lambda a: a * n
#
# mydoubler = myfunc(2)
# mytripler = myfunc(3)
# print(mydoubler(11))
# print(mytripler(11))

# f2 = lambda: 100
# print(f2)       # 打印lambda地址
# print(f2())

# f2 = lambda a, b: a + b
# print(f2)
# print(f2(1,2))

# f1 = lambda a:a
# print(f1("Hello"))

# f1 = lambda a,b,c = 10:a+b+c
# print(f1(10,20))

# f1 = lambda *args :args
# print(f1(0,20,30))

# f1 = lambda **kwargs: kwargs
# print(f1(name="Cra2iTeT", age=20))

# import functools
#
# list1 = [1, 2, 3, 4, 5]
# def func(a, b):
#     print(f"a=>{a},b=>{b}")
#     return a + b
#
# result = functools.reduce(func,list1)
# print(result)

# list1 = [1, 2, 3, 4, 5, 6, 7, 8, 9]
#
# def func(x):
#     return x % 2 == 0
#
# result = filter(func,list1)
# print(result)       # 返回地址
# print(list(result))
