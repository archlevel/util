import java.math.BigInteger;
import java.util.*;

public class IDUtil {

    private static int inc = 0;

    private static final String DEFAULT_DIGITS = "0";
    private static final String FIRST_DEFAULT_DIGITS = "1";

    public static Long hash3Long(String key, long seed) {
        char[] chars = key.toCharArray();
        //$key = array_values(unpack('C*', $key));
        int len = chars.length;
        long h1 = seed < 0 ? -seed : seed;
        int remainder = 0;
        int i = 0;
        for (int bytes = len - (remainder = len & 3); i < bytes; ) {
            long k1 = chars[i]
                    | (chars[++i] << 8)
                    | (chars[++i] << 16)
                    | (chars[++i] << 24);
            ++i;
            k1 = ((((k1 & 0xffff) * 0xcc9e2d51) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0xcc9e2d51) & 0xffff) << 16))) & 0xffffffff;
            k1 = k1 << 15 | (k1 >= 0 ? k1 >> 17 : ((k1 & 0x7fffffff) >> 17) | 0x4000);
            k1 = ((((k1 & 0xffff) * 0x1b873593) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0x1b873593) & 0xffff) << 16))) & 0xffffffff;
            h1 ^= k1;
            h1 = h1 << 13 | (h1 >= 0 ? h1 >> 19 : ((h1 & 0x7fffffff) >> 19) | 0x1000);
            long h1b = ((((h1 & 0xffff) * 5) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 5) & 0xffff) << 16))) & 0xffffffff;
            h1 = (((h1b & 0xffff) + 0x6b64) + (((((h1b >= 0 ? h1b >> 16 : ((h1b & 0x7fffffff) >> 16) | 0x8000)) + 0xe654) & 0xffff) << 16));
        }
        long k1 = 0;
        switch (remainder) {
            case 3:
                k1 ^= chars[i + 2] << 16;
            case 2:
                k1 ^= chars[i + 1] << 8;
            case 1:
                k1 ^= chars[i];
                k1 = (((k1 & 0xffff) * 0xcc9e2d51) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0xcc9e2d51) & 0xffff) << 16)) & 0xffffffff;
                k1 = k1 << 15 | (k1 >= 0 ? k1 >> 17 : ((k1 & 0x7fffffff) >> 17) | 0x4000);
                k1 = (((k1 & 0xffff) * 0x1b873593) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0x1b873593) & 0xffff) << 16)) & 0xffffffff;
                h1 ^= k1;
        }
        h1 ^= len;
        h1 ^= (h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000);
        h1 = (((h1 & 0xffff) * 0x85ebca6b) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 0x85ebca6b) & 0xffff) << 16)) & 0xffffffff;
        h1 ^= (h1 >= 0 ? h1 >> 13 : ((h1 & 0x7fffffff) >> 13) | 0x40000);
        h1 = ((((h1 & 0xffff) * 0xc2b2ae35) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 0xc2b2ae35) & 0xffff) << 16))) & 0xffffffff;
        h1 ^= (h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000);
        return h1;
    }

    public static Integer hash3Int(String key, int seed) {
        char[] chars = key.toCharArray();
        //$key = array_values(unpack('C*', $key));
        int len = chars.length;
        int h1 = seed < 0 ? -seed : seed;
        int remainder = 0;
        int i = 0;
        for (int bytes = len - (remainder = len & 3); i < bytes; ) {
            int k1 = chars[i]
                    | (chars[++i] << 8)
                    | (chars[++i] << 16)
                    | (chars[++i] << 24);
            ++i;
            k1 = ((((k1 & 0xffff) * 0xcc9e2d51) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0xcc9e2d51) & 0xffff) << 16))) & 0xffffffff;
            k1 = k1 << 15 | (k1 >= 0 ? k1 >> 17 : ((k1 & 0x7fffffff) >> 17) | 0x4000);
            k1 = ((((k1 & 0xffff) * 0x1b873593) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0x1b873593) & 0xffff) << 16))) & 0xffffffff;
            h1 ^= k1;
            h1 = h1 << 13 | (h1 >= 0 ? h1 >> 19 : ((h1 & 0x7fffffff) >> 19) | 0x1000);
            int h1b = ((((h1 & 0xffff) * 5) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 5) & 0xffff) << 16))) & 0xffffffff;
            h1 = (((h1b & 0xffff) + 0x6b64) + (((((h1b >= 0 ? h1b >> 16 : ((h1b & 0x7fffffff) >> 16) | 0x8000)) + 0xe654) & 0xffff) << 16));
        }
        int k1 = 0;
        switch (remainder) {
            case 3:
                k1 ^= chars[i + 2] << 16;
            case 2:
                k1 ^= chars[i + 1] << 8;
            case 1:
                k1 ^= chars[i];
                k1 = (((k1 & 0xffff) * 0xcc9e2d51) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0xcc9e2d51) & 0xffff) << 16)) & 0xffffffff;
                k1 = k1 << 15 | (k1 >= 0 ? k1 >> 17 : ((k1 & 0x7fffffff) >> 17) | 0x4000);
                k1 = (((k1 & 0xffff) * 0x1b873593) + (((((k1 >= 0 ? k1 >> 16 : ((k1 & 0x7fffffff) >> 16) | 0x8000)) * 0x1b873593) & 0xffff) << 16)) & 0xffffffff;
                h1 ^= k1;
        }
        h1 ^= len;
        h1 ^= (h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000);
        h1 = (((h1 & 0xffff) * 0x85ebca6b) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 0x85ebca6b) & 0xffff) << 16)) & 0xffffffff;
        h1 ^= (h1 >= 0 ? h1 >> 13 : ((h1 & 0x7fffffff) >> 13) | 0x40000);
        h1 = ((((h1 & 0xffff) * 0xc2b2ae35) + (((((h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000)) * 0xc2b2ae35) & 0xffff) << 16))) & 0xffffffff;
        h1 ^= (h1 >= 0 ? h1 >> 16 : ((h1 & 0x7fffffff) >> 16) | 0x8000);
        return h1;
    }

    public static String hash3LongHex(String key) {
        return hash3LongHex(key,Long.MAX_VALUE);
    }

    public static String hash3LongHex(String key, long seed) {
        Long hash = hash3Long(key, seed);
        return Long.toHexString(hash.intValue());
    }

    public static String hash3IntHex(String key) {
        return hash3IntHex(key,Integer.MAX_VALUE);
    }

    public static String hash3IntHex(String key,Integer seed) {
        Integer hash = hash3Int(key,seed);
        return Integer.toHexString(hash.intValue());
    }
    private static final int BASE_NUM = 62;
    private static final char[] GENERATE_SOURCE = new char[]{'0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z'};
    private static final int STR_LEN = GENERATE_SOURCE.length;

    /**
     * 生成数字和字母组合，字母区分大小写
     *
     * @param length 随机字符串的长度
     * @return
     */
    public static String generateByRandom(final int length) {
        StringBuilder randomSb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 输出字母还是数字
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 字符串
            if ("char".equals(charOrNum)) {
                // 判断字母大小写
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                randomSb = randomSb.append((char) (choice + random.nextInt(26)));
            } else {
                randomSb = randomSb.append(random.nextInt(10));
            }
        }
        return randomSb.toString();
    }

    /**
     * 生成随机字符串，generateByRandom的简化版
     *
     * @param count  随机字符串的长度
     * @param source 源字符集
     * @return
     */
    public static String doGenerate(int count, String[] source) {
        StringBuilder sb = new StringBuilder(count);
        int sourceLen = source.length;
        for (int i = 0; i < count; i++) {
            final int index = new Random().nextInt(sourceLen);
            sb.append(source[index]);
        }
        return sb.toString();
    }
    /**
     * @param target 目标数字
     * @param length 需要补充到的位数, 补充默认数字[0], 第一位默认补充[1]
    * @return   补充后的结果
    */
    public static String makeUpNewData(String target, int length){
        return makeUpNewData(target, length, DEFAULT_DIGITS);
   }
    
   /**
    * @param target 目标数字
    * @param length 需要补充到的位数
    * @param add  需要补充的数字, 补充默认数字[0], 第一位默认补充[1]
    * @return   补充后的结果
    */
    public static String makeUpNewData(String target, int length, String add){
        if(target.startsWith("-")) target.replace("-", "");
        if(target.length() >= length) return target.substring(0, length);
        StringBuffer sb = new StringBuffer(FIRST_DEFAULT_DIGITS);
        for (int i = 0; i < length - (1 + target.length()); i++) {
            sb.append(add);
        }
        return sb.append(target).toString();
    }

   /**
    * 生产一个随机的指定位数的字符串数字
    * @param length
    * @return
    */
   public static String randomDigitNumber(int length){
        int start = Integer.parseInt(makeUpNewData("", length));//1000+8999=9999
        int end = Integer.parseInt(makeUpNewData("", length + 1)) - start;//9000
        return (int)(Math.random() * end) + start + "";
   }

    public static Long frameId(){
       String frameId = makeUpNewData(Thread.currentThread().hashCode()+"", 3)+ randomDigitNumber(7); //随机7位数
       return Long.valueOf(frameId);
    }

    public static Long parseCompactId(String compactId){
        byte[] bytes = Base64.getUrlDecoder().decode(compactId);
        return Long.valueOf(new String(bytes));
    }

    public static String toCompactId(Long orignId) {
        return Base64.getUrlEncoder().withoutPadding().encodeToString(orignId.toString().getBytes());
    }

    private static int scale = 62;
    private static char ZERO = '0';
    static final char[] CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
            'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public static String toShort(String value){
        String md5 = Md5Util.md5(value);
        BigInteger aa = hex2Dec(md5);
        String bb = to62Str(aa);
        return bb;
    }

    private static BigInteger hex2Dec(String hex){
        int len=hex.length();
        BigInteger result = new BigInteger("0");

        for(int i=0;i<len;i++) {
            long tmpRsl=0;
            char val = hex.charAt(len - i - 1);
            if (val >= 'A' && val <= 'F') {
                tmpRsl += Integer.valueOf(val - 55) * Math.pow(16, i);//A是65，B\是66，减去55刚好是10、11

            } else {
                tmpRsl += Integer.valueOf(val - 48) * Math.pow(16, i);//48是数字0。val-48就是int型数值
            }
            result = result.add(new BigInteger(String.valueOf(tmpRsl)));
        }
        return result;
    }

    /**
     * 将数字转为62进制 * * @param num Long 型数字 * @param length 转换后的字符串长度，不足则左侧补0 * @return 62进制字符串
     */
    private static String to62Str(BigInteger num) {
        StringBuilder sb = new StringBuilder();
        BigInteger remainder = new BigInteger("0");
        while (num.compareTo(new BigInteger("61")) > 0) {
            /** * 对 scale 进行求余，然后将余数追加至 sb 中，由于是从末位开始追加的，因此最后需要反转（reverse）字符串 */
            remainder = num.mod(new BigInteger("62"));
            sb.append(CHARS[remainder.intValue()]);
            num = num.divide(new BigInteger("62"));
        }
        sb.append(CHARS[num.intValue()]);
        String value = sb.reverse().toString();
        return value;
    }
    public static void main(String[] args){
        String sLongUrl = "https://neudevice.oss-cn-shanghai.aliyuncs.com/images/202208/2b0bf000011c25000001363742595650/12c941c4-3c4a-4134-869f-bc0cf309e5d4/0..jpg?OSSAccessKeyId=LTAI4G1DNjFtY9BMY9WDiwNc&Expires=1663073638&Signature=MiM7XFwhBVfj85zlFwzqugHvYgM%3D";
        String shortStr = toShort(sLongUrl);
        System.out.println(shortStr);
    }
}
