package cn.chinattclub.izou7AppServer.filter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.chinattclub.izou7AppServer.dto.ConstantsDto;
import cn.chinattclub.izou7AppServer.dto.StatelessTokenDto;

/**
 * 无状态访问控制器
 * @author ZY
 *
 */
public class StatelessAuthcFilter extends AccessControlFilter {
	
	private static final Logger logger = LoggerFactory
			.getLogger(StatelessAuthcFilter.class);
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //1、客户端生成的消息摘要
        String clientDigest = request.getParameter(ConstantsDto.PARAM_DIGEST);
        //2、客户端传入的用户身份
        String username = request.getParameter(ConstantsDto.PARAM_USERNAME);
        //3、客户端请求的参数列表
        Map<String, String[]> params = new HashMap<String, String[]>(request.getParameterMap());
        params.remove(ConstantsDto.PARAM_DIGEST);
        //4、生成无状态Token
        StatelessTokenDto token = new StatelessTokenDto(username, params, clientDigest);
        try {
            //5、委托给Realm进行登录
            getSubject(request, response).login(token);
        } catch (Exception e) {
            logger.error("拒绝【"+username+"】访问！",e);
            return false;
        }
        return true;
    }
}
