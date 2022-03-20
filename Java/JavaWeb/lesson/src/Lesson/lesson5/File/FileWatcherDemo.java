package com.lesson5.File;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;


public class FileWatcherDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����һ��WatchService���󣬴˶������ڹ����ض��ļ��еı䶯��Ϣ���С�
		try(WatchService service=FileSystems.getDefault().newWatchService()) {
			//�˼��Ͽɱ������ļ��еļ����Ϣ����ǰֻʹ����һ��
			Map<WatchKey, Path> keyMap=new HashMap<>();
			Path path=Paths.get("D:\\test");
			//����WatchService���������ڲ����У�������ָ�����ļ��еĴ�����ɾ�����޸��¼���Ϣ
			//���ص�WatchKey��������ڴ��¼������л�ȡ�¼�����
			WatchKey key=path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
			keyMap.put(key, path);
			
			do {
				//��ʼ��أ������ȴ���������Ȥ���¼�����ʱ��take()�������ء�
				key=service.take();
				Path eventDir=keyMap.get(key);
				//���¼���������ȡ���е��¼�
				for (WatchEvent<?> event : key.pollEvents()) {
					//��ʲô���͵��¼���
					WatchEvent.Kind<?> kind=event.kind();
					//���ĸ��������˱䶯��
					Path eventPath=(Path)event.context();
					System.out.println(eventDir+":"+kind+":"+eventPath);
				}
			} while (key.reset()); //reset�������ô˶�������������½�����Ϣ
			
		} catch (Exception e) {
			
		}

	}

}
