package com.songyinghui.cms.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
  static String Salt="1a2b3c";
  public static String jiami(String str) {
	  
	  return DigestUtils.md5Hex(str+Salt);
  }
}
