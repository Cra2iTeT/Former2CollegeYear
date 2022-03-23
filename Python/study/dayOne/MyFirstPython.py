"""
@Project ：study 
@File    ：MyFirstPython.py
@IDE     ：PyCharm 
@Author  ：Cra2iTeT
@Date    ：2022/3/18 19:57 
"""
# 数据类型和py特性

# print("Hello,Cra2iTeT")

# input("\n\n按下enter后退出")

# myInt = 123
# print(type(myInt))
# # print(myInt)
# myStr = "123"
# print(type(myStr))

# if myInt == 123:
#     print("int")
# if myStr == 123:
#     print("str")

# a, b, c,d = 1, 1.1, "test",1+2j
# print(type(a), type(b), type(c),type(d))
# print(a, b, c,d)

# String
# str = "Cra2iTeT"
# print(str[0])
# print(str[1:2])     # 不包括2
# print(str[0:])
# print(str[0:-1])        # 包括倒二
# print(str + "!!!")
# print(str[-1:])
# print(str[1:6:3])       # 每3个输出
# print(str[6:1:-3])       # 每3个输出
# print(str[-4:-1:-1])        # 选取方向和下标方向冲突就无法输出

# list 列表
# d = [1, 2, 3]
# print(type(d))
# print(d)
# print(d[1])
# print(d[0:])
# print(d[0:2])
# print(d * 2)        # 输出两次
# d[1] = [3]
# print(d[1])

# tuple 元组
# d = (1, 2, 3)
# print(type(d))
# print(d)
# print(d[1])
# print(d[0:])
# print(d[0:2])
# print(d * 2)        # 输出两次

# set 集合
# a = set('abracadabra')
# b = set('alacazam')
# print(a)
# print(a - b)     # a 和 b 的差集
# print(a | b)     # a 和 b 的并集
# print(a & b)     # a 和 b 的交集
# print(a ^ b)     # a 和 b 中不同时存在的元素

# Dictionary 字典
# dict = {}
# dict['one'] = "1 - 菜鸟教程"
# dict[2]     = "2 - 菜鸟工具"
# tinydict = {'name': 'runoob','code':1, 'site': 'www.runoob.com'}
# print (dict['one'])       # 输出键为 'one' 的值
# print (dict[2])           # 输出键为 2 的值
# print (tinydict)          # 输出完整的字典
# print (tinydict.keys())   # 输出所有键
# print (tinydict.values()) # 输出所有值

# age = 20
# print("我的年龄是：%d" % age)
# print("我的年龄是：%03d" % age)
# weight = 75.0
# print("我的体重是：%.2f" % weight)
# print("我的年龄是：%d,我的体重是：%.2f" % (age, weight))

# myIn = input("请输入：")
# print(f'输入的数据：{myIn}')
# print(type(myIn))

# import sys
# print('================Python import mode==========================')
# print ('命令行参数为:')
# for i in sys.argv:
#     print (i)
# print ('\n python 路径为',sys.path)