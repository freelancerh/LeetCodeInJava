package range_60_80;

/**
 * 字符串,状态机,数学
 */
public class No67_AddBinary {
    public String addBinary(String a, String b) {
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int len1 = a.length();
        int len2 = b.length();
        int min = 0;
        int max = 0;
        String maxStr = null;
        if(len1 > len2){
            min = len2;
            max = len1;
            maxStr = a;
        }

        else{
            min = len1;
            max = len2;
            maxStr = b;
        }

        boolean flag = false;
        StringBuffer sb = new StringBuffer();
        int i;
        for(i=0; i<min; i++){
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if(c1=='1' && c2=='1' && flag){
                sb.append(c1);
                flag = true;
            }
            else if(c1=='1' && c2=='1' && !flag){
                sb.append('0');
                flag = true;
            }
            else if(c1=='0'&&c2=='1'&&flag || c1=='1'&&c2=='0'&&flag){
                sb.append('0');
                flag = true;
            }
            else if(c1=='0'&&c2=='1'&&!flag || c1=='1'&&c2=='0'&&!flag){
                sb.append('1');
                flag = false;
            }
            else if(c1=='0' && c2=='0' && flag){
                sb.append('1');
                flag= false;
            }
            else{
                sb.append('0');
                flag =false;
            }
        }


        for(int j=i; j<max; j++){
            char c1 = maxStr.charAt(j);
            if(c1=='0' && !flag)
                sb.append('0');
            else if(c1=='1' && !flag){
                sb.append('1');
            }
            else if(c1=='0' && flag){
                sb.append('1');
                flag = false;
            }
            else if(c1=='1' && flag){
                sb.append('0');
                flag = true;
            }
        }
        if(flag)
            sb.append('1');
        return sb.reverse().toString();
    }
}
