package com.hql.frame;

import org.eclipse.swt.widgets.Text;

public class Demo {

	public static Text initL;

	public static void log(String log) {
		if (initL != null && !initL.isDisposed()) {
			initL.append(log + "\r\n");
		}else{
			System.out.println(log + "\r\n");
		}
	}
}
