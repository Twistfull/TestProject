package com.bms.reader.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class check {
	public void check() {   
	       Method[] methods = this.getClass().getMethods();   
		       for (int i = 0; i < methods.length; i++) {   
		            Method method = methods[i];   
		            if (method.getName().startsWith("set")   
		                   && (method.getParameterTypes())[0].getName().equals(String.class.getName())) {   
		                try {   
		                    method.invoke(this);   
		                } catch (IllegalArgumentException e) {   
		                    e.printStackTrace();   
		                } catch (IllegalAccessException e) {   
		                    e.printStackTrace();   
		                } catch (InvocationTargetException e) {   
		                    e.printStackTrace();   
		                }   
		            }   
		    }
    }
}
