/**
 * Created by C.A.O on 2018/6/20.
 */
public class TestSplit {
    public static void main(String[] args) {
        String str = "zcy.onlineInquiry.purchase,zcy.onlineInquiry.agency,zcy.onlineInquiry.superviser.financeCheck,zcy.customer.businessSearch,zcy.onlineInquiry.superviser.search.district,zcy.onlineInquiry.superviser.search.dep,zcy.onlineInquiry.purchase.supserSearch,zcy.commission.purchase.order.commit,zcy.commission.purchase.order.firstCheck,zcy.commission.purchase.order.secondCheck,zcy.commission.purchase.order.finalCheck,zcy.commission.agency.organizationCheck,zcy.commission.agency.centerCheck,zcy.agreementSupply.supplier.bidding";

        String[] array = str.split(",",100);

        System.out.println(array.length);
        for(String str22 : array){
            if(null == str22){
                System.out.println("null");
            }else if("".equals(str22)){
                System.out.println("空字符串");
            }else {
                System.out.println(str22);
            }
        }
    }
}
