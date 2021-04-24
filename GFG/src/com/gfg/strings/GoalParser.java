package com.gfg.strings;

public class GoalParser {
	public static String interpret(String command) {
        StringBuilder sb = new StringBuilder("");
        StringBuilder res = new StringBuilder("");
        boolean flag = false;
        for(int i = 0; i < command.length(); i++){
            sb.append(String.valueOf(command.charAt(i)));
            switch(sb.toString()){
                case "G":
                    res.append(sb);
                    flag = true;
                    break;
                case "()":
                    res.append("o");
                    flag = true;
                    break;
                case "(al)":
                    res.append("al");
                    flag = true;
                    break;
                default:
                    break;
            }
            if(flag) {
                sb = new StringBuilder("");
                flag = false;
            }
            
        }
        return res.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(interpret("(al)G(al)()()G"));
	}
}
