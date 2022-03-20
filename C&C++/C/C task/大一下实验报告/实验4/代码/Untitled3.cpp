#include <iostream>
using namespace std;

/*����������д��*/
//Cra2iTeT
template <class T>
   class Node{
       public:
            T data;
            Node<T> *next;
            T getData(void)
			{
              return data;
            }
            Node(T a=0)//��������ĳ�ʼ����
			{
				this->next=NULL;
				data=a;
                cout<<"Node Constructor run"<<endl;
            }
            Node(Node &t)
			{
				this->next=t.next;
				data=t.data;
                cout<<"Node CopyConstructor run"<<endl;
            }
            ~Node()//�ڵ������������
			{
                cout<<"Node Destructor run"<<endl;
            }
   };
   //�����򣬰���ͷ�������ָ꣨��ָ������λ�ã���
   template<class T>
    class LinkList:public Node<T>{
        Node <T>*headNode;
        int position;
    public:
        LinkList(T *a=NULL,int da=0)//����ĳ�ʼ����
		{
			position=1;
			int i=1;
			headNode=new Node<T>;
			Node<T> *node1;
			node1=headNode;
			node1->data=a[0];
			while(i<da)
			{
				Node<T> *node2;
				node2=new Node<T>;
				node1->next=node2;
				node2->data=a[i];
				node1=node2;
				i++;
			}
            cout<<"LinkList Constructor run"<<endl;
        }
        LinkList(LinkList &t)//����Ŀ���
        {
			headNode=new Node<T>;
			Node<T>*node1;
			node1=headNode;
			Node<T>*node2;
			node2=t.headNode;
			node1->data=node2->data;
			while(node2->next!=NULL)
			{
				Node<T> *node3;
				node3=new Node<T>;
				node1->next=node3;
				node3->data=node2->next->data;
				node1=node3;
				node2=node2->next;
			}
            position=t.position;
            cout<<"LinkList CopyConstructor run"<<endl;
        }
        ~LinkList()//�����������ֻɾ���� new���͵Ľڵ㡣
        {
        	Node<T> *node1=headNode;
        	Node<T> *node2;
        	while(node1!=NULL)
        	{
        		node2=node1;
        		node1=node1->next;
        		delete node1;
			}
            cout<<"LinkList Destructor run"<<endl;
        }
        void insertNode(Node<T>&pt)//���������һ��ͬ���͵����ݡ�
        {
			Node<T> *node1;
			node1=headNode;
			int i=1;
			Node<T> *node2;
			if(position==1)
			{
				pt.next=headNode;
				headNode=&pt;
			}
			else{
			while(i<position)
			{
				node2=node1;
				node1=node1->next;
				i++;
			}
			pt.next=node2->next;
			node2->next=&pt;
           }  
        }
        bool searchNode(T value)//������Ԫ������Ѱ��value��ͬ���ݵ�Ԫ�ء�
        {
    		Node<T> *node;
    		node=headNode;
    		bool flag=false;
    		while(node!=NULL)
    		{
    		 if(node->data==value)
    			 {
    			 	flag=true;
    			 	break;
				 }
			 else next();
			node=node->next;
			}
			if(!flag)  position=1;
			return flag;
        }
        int getSize()//��Ⲣ���������д洢��Ԫ�صĸ�����
        {
        	int i=0;
        	Node<T>*node;
        	node=headNode;
        	while(node!=NULL)
        	{
        		i++;
        		node=node->next;
			}
            return i;
        }
        void next()//�����ƶ���ָ����һλ�á�
        {
			position++;
        }
        Node<T>& currNode()const//����������ڵĽڵ㡣
        {
			Node<T> *node;
			node=headNode;
			int i=1;
			while(i<position)
			{
				node=node->next;
				i++;
			}
			return *node;
        }
        void delNode()//ɾ����괦�Ľڵ㡣
        {
			Node<T> *node1;
			node1=headNode;
			int i=1;
			Node<T> *node2;
			if(position==1)
			{
				headNode=node1->next;
			}
			else{
				while(i<position)
			{
				node2=node1;
				node1=node1->next;
				i++;
			}
			node2->next=node1->next;
			}
        }
        void show()//��������Ԫ�ص�������ʾ����Ļ�ϡ�
		{
			Node<T>*node;
			node=headNode;
			while(node!=NULL)
			{
				cout<<"["<<node->data<<"]";
				node=node->next;
			}
			cout<<endl;
		}
   };
int main()
{
    int i,a[5]= {0,1,2,3,4};
    for(i=0;i<5;i++)
        scanf("%d",&a[i]);
    LinkList<int> l1(a,5),l2(l1);
    cout<<l2.getSize()<<endl;
    l1.show();
    if (l2.searchNode(2))
        cout<<"Found:"<<l2.currNode().getData()<<endl;
    else
        cout<<"Not Found"<<endl;
    l2.delNode();
    Node <int> *p1=new Node<int>(11);
    l2.insertNode(*p1);
    l2.show();
    return 0;
}
