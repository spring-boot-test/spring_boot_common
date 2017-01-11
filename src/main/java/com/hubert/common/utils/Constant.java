package com.hubert.common.utils;

import java.util.Calendar;

/**
 * 系统常量定义
 * 
 * @author JackDou
 * @since 2012-8-1
 */
public class Constant {

    private Constant() {
    }

    public static final String APP_CONFIG_FILE_NAME = "config.properties";

    public static final String LOG4J_FILE_PATH = "log4j.xml";

    public static final String TEST_PROPERTIES_FILE_NAME = "test.properties";

    public static final String CHARSET = "utf-8";

    public static final String IS_SUPPORT_QUERY_PARAM_AUTH_KEY = "is.support.query.param.auth";

    public static final String IS_SUPPORT_NO_PASSWORD_LOGIN_KEY = "is.support.no.password.login";

    public static final String LOG_PARENT_PATH_KEY = "log.parent.path";

    public static final String ONLINE_USER_ACTIVE_TIME_KEY = "online.user.active.time";

    public static final String ORG_QUARTZ_THREAD_POOL_COUNT_KEY = "org.quartz.thread.pool.count";

    public static final String CLEAR_NO_ACTIVE_USER_CRON_EXPRESSION_KEY = "clear.no.active.user.cron.expression";

    public static final String USR_ADMIN_LIST_KEY = "usr.admin.list";

    public static final String JAXB_PACKAGE_NAMES_KEY = "jaxb.package.names";

    public static final String CMS_CATEGORY_EDUBABYID_KEY = "cms.category.edubabyid";
    
    public static final String MOBILE_SOFT_DIR_KEY = "mobile.soft.dir";
    
    public static final String PICS_SAVA_PATH_KEY = "pics.sava.path";
    
    public static final String PHONE_REGISTER_TYPE = "2";
    
    public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
    
    public static final String YYYY_MM_DD_HH_MM_SS_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public static final String UPLOADFILE_WEB_ROOT_URL_KEY = "uploadfile.web.root.url";
    
    public static final String UPLOADFILE_MICROBLOG_ROOTPATH = "/uploadfile/microblog";
    
    public static final String UPLOADFILE_DIARY_ROOTPATH = "/uploadfile/diary";

    /**
     * 用户类型
     */
    public enum UserCategory {
        TEACHER("1"), // 老师
        PARENT("2"), // 家长
        BABY("3"); // 宝宝
        private String value;

        private UserCategory(String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value
         *            the value to set
         */
        public void setValue(String value) {
            this.value = value;
        }
    }

    public enum NoticeChannel {
        CLASS_NOTICE("班级公告"), SCHOOL_NOTICE("学校公告"), HONOUR_ROLL("光荣榜"), MESSAGE(
                "留言板"), DINING("食谱"), SCHOOL_NEWS("学校新闻"), CLASS_ACTIVITIE(
                "班级活动"), COURSE_PLAN("课程计划");
        private String value;

        private NoticeChannel(String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value
         *            the value to set
         */
        public void setValue(String value) {
            this.value = value;
        }
    }

    public enum WeekValue {
        MONDAY("mon", 1), TUESDAY("tues", 2), WEDNESDAY("wed", 3), THURSDAY("thur", 4), FRIDAY(
                "fri", 5), SATURDAY("sat", 6), SUNDAY("sun", 7);
        private String strVal;
        
        private Integer intVal;

        private WeekValue(String strVal, Integer intVal) {
            this.strVal = strVal;
            this.intVal = intVal;
        }

        /**
         * @return the strVal
         */
        public String getStrVal() {
            return strVal;
        }

        /**
         * @param strVal the strVal to set
         */
        public void setStrVal(String strVal) {
            this.strVal = strVal;
        }

        /**
         * @return the intVal
         */
        public Integer getIntVal() {
            return intVal;
        }

        /**
         * @param intVal the intVal to set
         */
        public void setIntVal(Integer intVal) {
            this.intVal = intVal;
        }
    }

    public enum DayValue {
        AM("am"), PM("pm"), NIGHT("night");
        private String value;

        private DayValue(String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value
         *            the value to set
         */
        public void setValue(String value) {
            this.value = value;
        }

    }
    
	public enum SexType {
		MEN("男", "1"), WOMEN("女", "2");
		private String value;
		private String numValue;

		private SexType(String value, String numValue) {
			this.value = value;
			this.numValue = numValue;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * @return the numValue
		 */
		public String getNumValue() {
			return numValue;
		}

		/**
		 * @param numValue
		 *            the numValue to set
		 */
		public void setNumValue(String numValue) {
			this.numValue = numValue;
		}
	}
    
	/**
	 * 阅读状态 1未阅读 2已阅读
	 */
	public enum MicroblogReadStatus {
		UNREAD("1"), READ("2");
		private String value;

		private MicroblogReadStatus(String value) {
			this.value = value;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value
		 *            the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}
	}
	
	   /**
     * 阅读状态 1未阅读 2已阅读
     */
    public enum ClassVideoCategory {
        BABY("baby"), CLASS("class"), SCHOOL("school");
        private String value;

        private ClassVideoCategory(String value) {
            this.value = value;
        }

        /**
         * @return the value
         */
        public String getValue() {
            return value;
        }

        /**
         * @param value
         *            the value to set
         */
        public void setValue(String value) {
            this.value = value;
        }
    }
    
    /**
     * 获取单号
     * @param type（业务缩写（TZSQ））
     * @return
     */
    public static String getFormNo(String type){
    	
		int x = (int) ((Math.random()*9+1)*100000);
		
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);

    	return type+year+x;
    }
    /**
     * 草稿
     */
    public static final String SHOP_DRAFT = "draft";
    
    /**
     * 已通过
     */
    public static final String SHOP_COMPLETED = "completed";
    
    /**
     * 审批中
     */
    public static final String SHOP_PROCESSING = "processing";
    
    /**
     * 已驳回
     */
    public static final String SHOP_RETURNED = "returned";
    
    /**
     * 已删除
     */
    public static final String SHOP_DELETED = "deleted";
    /**
     * 租户营运岗
     */
    public static final String SHOP_YYG = "租户营运岗";
    /**
     * 租户财务岗
     */
    public static final String SHOP_CWG = "租户财务岗";
    /**
     * 租户管理层
     */
    public static final String SHOP_GLC = "租户管理层";
    /**
     * 发送租户
     */
    public static final String SHOP_MSG_TYLE = "tenant";
    
    /**
     * 流程消息
     */
    public static final String SHOP_MSG_TYLE_PROCESS = "流程审批提醒";
    
    /**
     * TC专员
     */
    public static final String SHOP_TCZY = "TC专员";
    
    /**
     * TC经理
     */
    public static final String SHOP_TCJL = "TC经理";
    
    /**
     * 营运经理
     */
    public static final String SHOP_YYJL = "营运经理";
    
    /**
     * 营运专员
     */
    public static final String SHOP_YYZY = "营运专员";
    
    public enum ProcessStatusDesc {
    	SHOP_DRAFT("草稿"), SHOP_COMPLETED("已通过"), SHOP_PROCESSING("审批中"), SHOP_RETURNED("已驳回"), SHOP_DELETED("已删除");

		private String value;

		private ProcessStatusDesc(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
    
    /*********************易正流程start*****************************/
    /**
     * 财务异常调账申请
     */
    public static final String ADJUST_APPLY = "财务异常调账申请";
    /**
     * 施工申请
     */
    public static final String CONSTRUCT_APPLY = "施工申请";
    
    
    /**
     *深圳万象城-货品放行申请
     */
    public static final String OPERAT_MANAGE = "货品放行申请";
    
    /**
     *滞纳金减免申请
     */
    public static final String OVERDUEFINE_SUBTRACT = "滞纳金减免申请"; 
    
    /**
     *违规积分检查 
     */
    public static final String SHOPROLE_POINTCHECK = "违规积分检查";
 
    /**
     *清洁铝梯借用申请
     */
    public static final String LADDER_BORROW = "清洁铝梯借用申请";
    


    /**
     *店铺活动申请
     */
    public static final String ACTIVITY = "店铺活动申请";

    /**
     *租户沟通记录
     */
    public static final String TENANT_LOG = "租户沟通记录";
    
    /**
     *空调加时申请
     */
    public static final String AIR_CONDITION = "空调加时申请";
 
    /**
     *商场活动申请
     */
    public static final String SHOP_ACTION = "商场活动申请";
    
 
    /**
     *围挡方案图纸审核
     */
    public static final String CHECK_SHELTER = "围挡方案图纸审核";

    /**
     *设计方案图纸审核
     */
    public static final String CHECK_DESIGN = "设计方案图纸审核";
    
    /**
     *沈阳万象城-装修施工图纸审核
     */
    public static final String CHECK_DECORAT = "装修施工图纸审核";
    
    /**
     *深圳万象城-盖章申请
     */
    public static final String STAMP = "盖章申请-审图意见函";
    /**
     *撤场移交
     */
    public static final String TRANSF = "撤场移交";
    /**
     *撤场验收
     */
    public static final String CHECK = "撤场验收";
    /**
     *重装申请
     */
    public static final String RESTAGING_APPLY = "重装申请";
    /**
     *盖章申请-竣工验收
     */
    public static final String TOSTAGING_APPLY = "盖章申请-竣工验收";
    
    /**
     *进场装修准备
     */
    public static final String TOSTAGING_INTO = "进场装修准备";
    
    /**
     *盖章申请-店铺接场
     */
    public static final String TOSTAGINGTRANSF_APPLY = "盖章申请-店铺接场";

    /**
     *审图申请
     */
    public static final String NOTIFY = "审图申请";
 
    /**
     *多倍积分申请
     */
    public static final String MULT_SCORE = "多倍积分申请";
 
    /**
     *积分补入
     */
    public static final String POINT_ADD= "积分补录申请";
    
    /**
     *店铺经营情况反馈
     */
    public static final String SHOP_OPERATE_FEEDBACK= "店铺经营情况反馈";

	 /**
     *店铺分析报告
     */
    public static final String SHOP_ANALYSE= "店铺分析报告";


    /**
     *装修押金退还
     */
    public static final String SHOP_REFUND= "装修押金退还";
    

    /**
     *退租赁保证金
     */
    public static final String SHOP_REFUND_RENT= "退租赁保证金";
 
    
    /**
     *店长
     */
    public static final String SHOP_MANAGER= "店长";
 
    /**
     *营业时间调整
     */
    public static final String SHOP_BUSINESS_TIME= "营业时间调整申请";
    
    /**
     *物品展示申请
     */
    public static final String SHOP_ITEMS_SHOW= "非经营性物品展示申请";
    
    /**
     *服务台资料摆放申请
     */
    public static final String SHOP_FRONT_DESK= "服务台资料摆放申请";
    
    /**
     *退质量保证金
     */
    public static final String SHOP_QUALITY_BOND= "退质量保证金";
    
    /**
     *消防报审
     */
    public static final String FIRE_REPORT= "消防报审";
 
    /**
     *消防备案
     */
    public static final String FIRE_RECORD= "消防备案";
    
	  /**
     *消防报验
     */
    public static final String FIRE_ACCEPTANCE= "消防报验";
    
    /**
     *店铺活动申请
     */
    public static final String SHOP_ACTIVITY= "店铺活动申请";

    /**
     * 安全增值服务申请
     */
    public static final String SAFETY_VALUE= "安全增值服务申请";
    
    /**
     * 广告资源申请
     */
    public static final String ADVERTISE_RESOURCES= "广告资源申请";

    /**
     * 会员短信申请
     */
    public static final String MEMBER_SMS= "会员短信申请";
    
    /**
     * 物料制作施工单
     */
    public static final String MATE_BILL= "物料制作施工单";
    
    /**
     * 深圳万象城-通知发布
     */
    public static final String NOTIFY_INFO= "通知发布";
    
    /**
     * 临时工作申请
     */
    public static final String TEMP_WORK_APPLY= "临时工作申请";
    
    /**
     * 店铺活动记录申请
     */
    public static final String SHOP_STORE_ACTIVITY= "店铺活动记录申请";
    
    /**************************易正流程end************************************/
    
    /**************************保存附件类型************************************/
    /**
     * 铝梯借用申请
     */
    public static final String ATTACHMENT_lADDER= "ladder";
    
 

  

    /*店铺移交状态*/
    public static final String STORE_HANDOVER_STATUS_OK= "B5";//TC确认移交更新
    
    /*店铺装修状态状态*/
    public static final String STORE_HANDOVER_NEW= "new";//新装
    
    public static final String STORE_HANDOVER_RESET= "reset";//重装
    
    /*工作台子项是否完成**/
    public static final String STORE_WORKBENCH_ISFINISH= "是";//已完成
    
    public static final String STORE_WORKBENCH_NOTFINISH= "否";//未完成
    
    public static final String STORE_WORKBENCH_ONGOING= "进行中";//进行中
    
    public static final String STORE_WORKBENCH_NOTBEGIN= "未开始";//未开始
    
    /*工作台是否完成**/
    public static final String STORE_WORKBENCH_FINISH= "已完成";//已完成
    
    /*工作台是否完成**/
    public static final String STORE_WORKBENCH_NOPASS= "未通过";//已完成
    
    
    public static final String STORE_WORKBENCH_OPEN= "已开业";//已完成
    /*新装工作台店铺装修状态**/
    public static final String STORE_WORKBENCH_NEW_NOTFINISH= "待装修";//
    
    public static final String STORE_WORKBENCH_NEW_ONGOING= "装修中";//
    
    /*重装工作台店铺装修状态**/
    public static final String STORE_WORKBENCH_RESET_NOTFINISH= "待重装";//
    
    public static final String STORE_WORKBENCH_RESET_ONGOING= "重装中";//
        
    /*撤场工作台店铺装修状态*/
    public static final String STORE_WORKBENCH_LEAVE_NOTFINISH= "待撤场";//
    
    public static final String STORE_WORKBENCH_LEAVE_FINISH= "已还场";//
    
    public static final String STORE_WORKBENCH_LEAVE_ONGOING= "撤场中";//
    
    
    public static final String POSITION_TYPE_HEADMAN = "营运组长";
    
    public static final String POSITION_TYPE_COMMISSIONER = "营运专员";
    
    
    /********************************高级过滤***************************************/
    /**
     * 等于：equal
     */
    public static final String FILTER_EQUAL = "equal";
    
    /**
     * 不过滤：nofilter
     */
    public static final String FILTER_NOFILTER = "nofilter";
    
    /**
     * 小于：less
     */
    public static final String FILTER_LESS = "less";
    
    /**
     * 大于：greater
     */
    public static final String FILTER_GREATER = "greater";
    
    /**
     * 租户端发起
     */
    public static final String PROCESS_TYPE = "1";
    
 }
