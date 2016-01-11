package infrastructure;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import data.BusinessRule;

public class ObjectDAO {
	public void save(BusinessRule br, String naam) {
		FileOutputStream fos;
		ObjectOutputStream oos;
		try {
			File f = new File(naam);
			if (f.exists()) {
				f.delete();
			}
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(br);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public BusinessRule load(String naam) {
		BusinessRule br = null;
		FileInputStream fis;
		ObjectInputStream ois;
		try {
			File f = new File(naam);
			if (f.exists()) {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				br=(BusinessRule) ois.readObject();
				ois.close();
				fis.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return br;
	}
}
