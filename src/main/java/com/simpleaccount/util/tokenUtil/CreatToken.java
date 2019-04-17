package com.simpleaccount.util.tokenUtil;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.simpleaccount.entry.UserInfo;
import com.simpleaccount.expction.CommonException;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: java类作用描述
 * @Author: Whyza
 * @CreateDate: 2019/3/22 11:42
 * @Version: 1.0
 */
@Component
public class CreatToken {
    /**
     * token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj
     */
    public static final String SECRET = "JKKLJOoasdlfj";
    /**
     * token 过期时间: 10天
     */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;

    /**
     * JWT生成Token.<br/>
     * <p>
     * JWT构成: header, payload, signature
     *
     * @param userInfo
     */
    public String createToken(UserInfo userInfo) {
        String token = "";
        try {
            Date iatDate = new Date();
            // expire time
            Calendar nowTime = Calendar.getInstance();
            nowTime.add(calendarField, calendarInterval);
            Date expiresDate = nowTime.getTime();

            Map<String, Object> map = new HashMap<>();
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            token = JWT.create().withHeader(map)
                    .withClaim("userName",userInfo.getUserName())
                    .withIssuedAt(iatDate)
                    .withExpiresAt(expiresDate)
                    .sign(Algorithm.HMAC256(SECRET));
        } catch (Exception e) {
            throw new CommonException(500, "创建token失败");
        }
        return token;
    }

    /**
     * 解密Token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            jwt = verifier.verify(token);
            if (jwt.getExpiresAt().before(new Date())) {
                throw new CommonException(500,"Token过期");
            }
        } catch (Exception e) {
            throw new CommonException(500,e.getMessage());
        }
        return jwt.getClaims();
    }
}
