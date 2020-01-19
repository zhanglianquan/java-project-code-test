package src.designpattern.responsibilitychain;

/**
 * @Author zhanglianquan
 * @Description 副经理
 * @Date 2020/1/19
 **/

public class AssistantManager extends Leader {
    private final String name = "副经理";
    private final int level = 1;
    @Override
    public void handle(Files file) {
        if(this.level > file.getLevel()){
            System.out.println(name + "未处理文件《" + file.getFileName() + "》");
            getNextLeader().handle(file);
        }else{
            System.out.println(name + "处理了文件《" + file.getFileName() + "》");
        }
    }
}
