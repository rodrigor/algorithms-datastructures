/**
 * 
 */
package util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Dummy singleton implementation.
 * @author Rodrigo Rebouças de Almeida (http://github.com/rodrigor)
 * @date Apr 30, 2017
 */
public class Util {
	
	private static Util singleton = null;
	private File projectBase;
	
	public static Util getInstance(){
		if(singleton == null)
			singleton = new Util();
		return singleton;
	}
	
	public Util(){
		try {
			File file = new File(this.getClass().getResource("/").toURI());
			this.projectBase =  new File(file.getParent());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public File getProjectBasePath(){
		return this.projectBase;
	}
	
	public String getAbsolutePath(String fileName){
		try {
			return this.projectBase.getCanonicalPath()+"/"+fileName;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

}
