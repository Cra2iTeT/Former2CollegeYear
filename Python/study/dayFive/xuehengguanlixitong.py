"""
@Project ：study 
@File    ：xuehengguanlixitong.py
@IDE     ：PyCharm 
@Author  ：Cra2iTeT
@Date    ：2022/3/22 14:39 
"""
info = []

def info_print():
    print("===========")
    print("1.添加学员")
    print("2.删除学员")
    print("3.修改学员")
    print("4.查询学员")
    print("5.显示所有学员")
    print("6.退出系统")
    print("===========")

def add_info():
    '''添加学员函数'''
    print("请输入学号：",end="")
    new_id = input()

    global info
    for single_info in info:
        if new_id == single_info['id']:
            print("学号已存在",end="")
            return

    print("请输入姓名：",end="")
    new_name = input()
    print("请输入手机号：",end="")
    new_tel = input()

    new_dict = {}

    new_dict['id'] = new_id
    new_dict['name'] = new_name
    new_dict['tel'] = new_tel
    # print(new_dict)

    info.append(new_dict)
    return

def delete_info():
    print("请输入需要删除的学员学号：",end="")
    old_id = input()

    global info
    for single_info in info:
        if old_id == single_info['id']:
            print(f"是否确定删除{info}\n1确认删除,任意键取消删除",end="")

            new_option = int(input())

            if new_option == 1:
                info.remove(single_info)
                return
            else:
                return
    print("未找到对应学号的学员")
    return

def update_info():
    print("请输入需要修改的学生学号：",end="")
    old_id = input()

    global info
    for single_info in info:
        if old_id == single_info['id']:
            print("查找到相关学生，信息如下：")
            print(f'{single_info}')

            print("请输入修改后的姓名：",end="")
            single_info['name'] = input()
            print("请输入修改后的手机号：",end="")
            single_info['tel'] = input()

            return

    print(f"未找到学号为{old_id}的学生")
    return

def query_info():
    print("请输入需要查询的学生学号：",end="")
    old_id = input()

    global info
    for single_info in info:
        if single_info['id'] == old_id:
            return single_info
    print(f"未找到学号为{old_id}的学生")
    return

def query_all_info():
    return info

while True:
    info_print()

    print("请输入功能序号：",end="")
    user_num = int(input())

    if user_num == 1:
        add_info()
    elif user_num == 2:
        delete_info()
    elif user_num == 3:
        update_info()
    elif user_num == 4:
        result = query_info()
        if result != None:
            print(result)
    elif user_num == 5:
        result = query_all_info()
        if result != None:
            for single_result in result:
                print(f"id:{single_result['id']}  name:{single_result['name']}  tel:{single_result['tel']}\t")
        else:
            print("学员列表为空")
    elif user_num == 6:
        print("是否确认退出系统,1确定退出，任意键取消退出：",end="")
        option = int(input())
        if option == 1:
            print("系统退出",end="")
            break
    else:
        print("输入的功能序号有误")