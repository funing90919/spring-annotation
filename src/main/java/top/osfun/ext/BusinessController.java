package top.osfun.ext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BusinessController {

    @Autowired//多个实现，按照名称注入
    private BusinessService businessServiceImpl;
}

