package server;
import java.util.HashMap;


public class RecordContainer {  //存起来各个Records
	
	protected long nextId = 10000;
	
	protected final Object idlock = new Object();   //TODO: 为什么用Object呀？
    final HashMap<String, Record>[] records = new HashMap[26];   //TODO:真正含义：包含26个hashmap的数组，每一个hashmap是用来存记录的
    final Object recordsLock = new Object();

	public static RecordContainer getRecordContainer(String name) {
		RecordContainer container = new RecordContainer();
        container.createRecordContainer();
        return container;
	}

	private void createRecordContainer() {
		for (int i = 0; i < 26; i++) {
            records[i] = new HashMap<String, Record>();
        }
	}

	public int getRecordCount() {
		int count = 0;
        synchronized (records) {            //TODO：算count的时候必须同步！
            for (HashMap map : records) {
                count += map.size();
            }
        }
        return count;
	}

	public long getNextFreeId() {   //TODO:用处？
		synchronized (idlock) {
            return nextId++;
		}
	}

	public void addRecord(Record record) {
		String lastName = record.getLastName();

        int entry = lastName.toLowerCase().codePointAt(0) - "a".codePointAt(0); //TODO:确保名字是以字母开头的，并且知道是第几个字母

        if (entry < 0 || entry >= 26) {
            throw new RuntimeException(lastName + " is a bad last name");
        }

        HashMap<String, Record> entries = records[entry];

        synchronized (entries) {
            entries.put(record.getId(), record);
        }
		
	}

	public void removeRecord(String id, String lastName) {
		int entry = lastName.toLowerCase().codePointAt(0) - "a".codePointAt(0);

        if (entry < 0 || entry >= 26) {
            throw new RuntimeException(lastName + " is a bad last name");
        }

        HashMap<String, Record> entries = records[entry];  //TODO:以字母的位置 找到某一个hashmap

        synchronized (entries) {
            entries.remove(id);
        }
	}

	public Record getRecord(String recordID) {
		for (HashMap<String, Record> entries : records) {
            synchronized (entries) {
                if (entries.containsKey(recordID)) {
                    return entries.get(recordID);
                }
            }
        }
        return null;
	}

}
