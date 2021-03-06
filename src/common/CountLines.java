package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

/**
 * 计算一个工程的代码行数
 * @author cylong
 * @version Oct 28, 2014 6:27:00 PM
 */
class CountLines {

	public static void main(String[] args) {
		CountLines count = new CountLines("src");
		System.out.println("codeSum:     " + count.codeSum);
		System.out.println("blankSum:    " + count.blankSum);
		System.out.println("commentSum:  " + count.commentSum);
		System.out.println("Sum:         " + (count.codeSum + count.blankSum + count.commentSum));
	}

	/** 代码行数 */
    private int codeSum = 0;
	/** 空白行数 */
    private int blankSum = 0;
	/** 注释行数 */
    private int commentSum = 0;

	private CountLines(String filePath) {
        getAllLines(filePath);
    }

	private int getAllLines(String filePath) {
        File file = new File(filePath);
        if (file.isDirectory()) {// 判断是否是文件夹
            File[] codeFiles = file.listFiles();
			if (codeFiles != null) {
				Arrays.stream(codeFiles).map(File::getPath).forEach(this::getAllLines);
			}
		} else {
            // 判断是否是java文件，除去本文件
            if (file.getName().endsWith(".java")
                && !file.getName().equals(this.getClass().toString().split("\\.")[1] + ".java")) {
                // 输出java文件名称
                // System.out.println(file.getName());
                codeSum += getOneFileLines(file)[0];
                blankSum += getOneFileLines(file)[1];
                commentSum += getOneFileLines(file)[2];
            }
        }
        return codeSum;
	}

	private int[] getOneFileLines(File file) {
		int codeSum = 0;	// 代码行数
		int blankSum = 0;	// 空白行数
		int commentSum = 0;	// 注释行数
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				line = line.trim();
				if (line.matches("^[\\s&&[^\\n]]*$")) {
					blankSum++;
				} else if (line.startsWith("//")) {
					commentSum++;
				} else if (line.startsWith("/*")) {
					commentSum++;
				} else if (line.startsWith("*")) {
					commentSum++;
				} else if (line.endsWith("*/")) {
					commentSum++;
				} else {
					codeSum++;
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new int[]{codeSum, blankSum, commentSum};
	}
}