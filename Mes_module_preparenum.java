
import java.io.Serializable;
import java.util.Date;
import java.math.*;


/** mes_module_preparenum
	ID    BIGINT(20)
	MODNO    VARCHAR(255)
	PREPARENUM    INT(11)
	BATCHID    INT(11)
	CREATETIME    DATETIME(19)
	CREATEBY    VARCHAR(255)
	WORKNO    VARCHAR(255)
	MODID    BIGINT(20)
	MODNUM    VARCHAR(11)
	PRODUCTIONREACH    FLOAT(11,1)
	TOTALPERSON    INT(11)
*/
public class Mes_module_preparenum implements Serializable {
	private static final long serialVersionUID = 1L;
	private null id;
	private String modno;
	private null preparenum;
	private null batchid;
	private Date createtime;
	private String createby;
	private String workno;
	private null modid;
	private String modnum;
	private float productionreach;
	private null totalperson;

	public void setId(null id){
		this.id=id;
	}
	public null getId(){
		return id;
	}
	public void setModno(String modno){
		this.modno=modno;
	}
	public String getModno(){
		return modno;
	}
	public void setPreparenum(null preparenum){
		this.preparenum=preparenum;
	}
	public null getPreparenum(){
		return preparenum;
	}
	public void setBatchid(null batchid){
		this.batchid=batchid;
	}
	public null getBatchid(){
		return batchid;
	}
	public void setCreatetime(Date createtime){
		this.createtime=createtime;
	}
	public Date getCreatetime(){
		return createtime;
	}
	public void setCreateby(String createby){
		this.createby=createby;
	}
	public String getCreateby(){
		return createby;
	}
	public void setWorkno(String workno){
		this.workno=workno;
	}
	public String getWorkno(){
		return workno;
	}
	public void setModid(null modid){
		this.modid=modid;
	}
	public null getModid(){
		return modid;
	}
	public void setModnum(String modnum){
		this.modnum=modnum;
	}
	public String getModnum(){
		return modnum;
	}
	public void setProductionreach(float productionreach){
		this.productionreach=productionreach;
	}
	public float getProductionreach(){
		return productionreach;
	}
	public void setTotalperson(null totalperson){
		this.totalperson=totalperson;
	}
	public null getTotalperson(){
		return totalperson;
	}
}

