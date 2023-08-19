import com.alibaba.fastjson.JSON;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;

public class AEStest {

    public static void main(String[] args) {
        /*String encryptedData="EUBJPwtHNpOMl7pOFdPOqr+uITQdgpTJhtn2IIFzTZyz9x/D0MTdu+2f9ED+fy3e4DqKckNo2ejccizevvHEmblzPUr36LxWYO1vDPfkAQcatlR5vvCtErj0YNoKpqkWixaT6mkm+b81csRr5jlpRZpm6MFumQbWUd1J043b/Pb+Rflw1ZeCULk6qS9qs5UJEQO26l36JAobT//P4tsR3w==";
        String iv="z8j+mVpfOJVGF/nF4MX+JQ==";
        String appId="小程序id";
        String sessionKey = "u3UP4Ct5+BGxwNYey4nBHQ==";

        AESForWXGetPhoneNumber aes =new AESForWXGetPhoneNumber(encryptedData,sessionKey,iv);
        WXPhoneDecryptInfo info=aes.decrypt();
        System.out.println(info);
        if (null==info){
            System.out.println("error");
        }else {
            if (!info.getWXWaterMark().getAppid().equals(appId)){
                System.out.println("wrong appId");
            }
            System.out.println(info.toString());
        }*/

        String encryptedData="t5/2BljZ+W3yyzplW5s5Kc2W8nTKVNmczMGRKPOvTtU9y1ttQVrKcs28+MyVeDjdd3MID565nHkh99GG07afhhFN4d5u9Dene4tFFJgAKkfIqlc6oyrXFP6ouP/TB5mFc9jbyrK4WVzDAlNnExsMyYVsrBz74CLk39q+I91kSyVcJhheaFTp+O7tOjPYTjhVeZ2kBXETXT9b8/P8BYd2Pw==";
        String sessionKey="hNJ2yr4wheOGlp5H1NnIMA==";
        String iv = "IUloipk7Q2AuwTpTGJlc2w==";

//        String sessionKey = "tiihtNczf5v6AKRyjwEUhQ==";
//        String encryptedData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==";
//        String iv = "r7BXXKkLb8qrSNn05n0qiA==";

        JSON info = AES.wxDecrypt(encryptedData, sessionKey, iv);
//        System.out.println(info);

        try {
            byte[] dataByte = Base64.decodeBase64(encryptedData);
            //加密秘钥
            byte[] keyByte = Base64.decodeBase64(sessionKey);
            //偏移量
            byte[] ivByte = Base64.decodeBase64(iv);

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            //生成iv
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                System.out.println(result);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
