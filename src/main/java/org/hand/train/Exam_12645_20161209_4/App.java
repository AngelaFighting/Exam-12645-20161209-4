package org.hand.train.Exam_12645_20161209_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{  
	
    public static void main( String[] args )
    {
    	List<Integer> list=new ArrayList<Integer>();
    	for(int i=0;i<50;i++){
    		list.add((int)(Math.random()*100));
    	}
    	Map<Integer,List<Integer>> map = 
    			new HashMap<Integer,List<Integer>>();
    	for(int num: list){
    		if(map.containsKey(num/10)){
    			map.get(num/10).add(num);
    		}else{
    			List<Integer> nums=new ArrayList<Integer>();
    			nums.add(num);
    			map.put(num/10, nums);
    		}
    	}
        System.out.print( "随机生成50个小于100的数，分别为：" );
        for(int i=0;i<49;i++){
        	System.out.print(list.get(i)+",");
        }
        System.out.println(list.get(49));
        System.out.print( "Map中的数据为：{" );
        List<Map.Entry<Integer, List<Integer>>> melist=new ArrayList(map.entrySet());
        Map.Entry<Integer, List<Integer>> me;
        for(int i=0;i<melist.size()-2;i++){
        	me=melist.get(i);
        	System.out.print(me.getKey()+"=>"+me.getValue()+",");
        }
        me=melist.get(melist.size()-1);
        System.out.println(me.getKey()+"=>"+me.getValue()+"}");
        System.out.print( "排序后的Map为：{" );
        for(int i=0;i<melist.size()-2;i++){
        	me=melist.get(i);
        	System.out.print(me.getKey()+"=>");        	
        	me.getValue().sort(new Comparator<Integer>(){
				public int compare(Integer arg0, Integer arg1) {
					if(arg0>arg1) return 1;
        			else return -1;
				}
        	});
        	System.out.print(me.getValue()+",");
        }
        me=melist.get(melist.size()-1);
        me.getValue().sort(new Comparator<Integer>(){
			public int compare(Integer arg0, Integer arg1) {
				if(arg0>arg1) return 1;
    			else return -1;
			}
    	});
        System.out.println(me.getKey()+"=>"+me.getValue()+"}");
    }
}
