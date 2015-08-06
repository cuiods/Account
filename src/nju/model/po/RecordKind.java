package nju.model.po;

import java.io.Serializable;

/**
 * there are five kinds of a record
 * TRANSPORTATION,//交通
 *	CATERING,//餐饮
 *	ENTERTAINMENT,//娱乐
 *	TRANSFERACOUNTS,//转账
 *	WAGE//工资
 */
public enum RecordKind implements Serializable{

	TRANSPORTATION,//交通
	CATERING,//餐饮
	ENTERTAINMENT,//娱乐
	TRANSFERACOUNTS,//转账
	WAGE//工资
}
