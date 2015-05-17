package com.lubby.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.lubby.bean.Gender;

/**
 * @author Lubby
 * @date 2015年5月17日 下午3:08:28
 *
 */

public class EnumTypeHandler implements TypeHandler<Gender> {

	public Gender getResult(ResultSet arg0, String arg1) throws SQLException {
		String gender = arg0.getString(arg1);
		if(gender == null || "".equals(gender)){
			return Gender.Male;
		}
		return Gender.valueOf(gender);
	}

	public Gender getResult(ResultSet arg0, int arg1) throws SQLException {
		String gender = arg0.getString(arg1);
		return Gender.valueOf(gender);
	}

	public Gender getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		String gender = arg0.getString(arg1);
		return Gender.valueOf(gender);
	}

	public void setParameter(PreparedStatement arg0, int arg1, Gender arg2,
			JdbcType arg3) throws SQLException {
		arg0.setString(arg1, arg2.name());
	}

}
