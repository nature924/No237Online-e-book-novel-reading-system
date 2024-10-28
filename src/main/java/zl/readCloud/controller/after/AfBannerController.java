package zl.readCloud.controller.after;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zl.readCloud.controller.after.dto.BannerDTO;
import zl.readCloud.pojo.BannerPO;
import zl.readCloud.pojo.BookPO;
import zl.readCloud.service.after.Impl.AfBannerServiceImpl;
import zl.readCloud.service.after.Impl.AfBookServiceImpl;
import zl.readCloud.utils.Result;
import zl.readCloud.utils.ToolsUtils;

import java.util.List;

/**
 * @author ZhangLei
 * @Description:
 * @date 2021/10/14 11:23
 */
@RequestMapping("/banner")
@RestController
public class AfBannerController {

    @Autowired
    private AfBannerServiceImpl afBannerService;

    @Autowired
    private AfBookServiceImpl afBookService;

    @GetMapping("/getBannerList")
    public Result getBannerList(Integer page, Integer limit) {
        if ( page == null) {
            return Result.error(0,"没有页数");
        }
        Integer pages = (page - 1) * limit;
        List<BannerDTO> list = afBannerService.getBannerList(pages, limit);
        Integer count = afBannerService.getBannerListCount();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setBaPicture(ToolsUtils.getImgPath(list.get(i).getBaPicture()));
        }
        return Result.success(Result.SUCCESS, count, list);
    }

    @PostMapping("/addBanner")
    public Result addBanner(@RequestBody BannerDTO bannerDTO ) {
        BookPO book = afBookService.showByBTitle(bannerDTO.getBTitle());
        BannerPO banner = new BannerPO();
        banner.setBaId(bannerDTO.getBaId());
        banner.setBaLevel(bannerDTO.getBaLevel());
        banner.setBaPicture(bannerDTO.getBaPicture());
        banner.setBId(book.getBId());
        banner.setStartDt(bannerDTO.getStartDt());
        banner.setEndDt(bannerDTO.getEndDt());
        return Result.success(afBannerService.addBanner(banner));
    }

    @PostMapping("/updateBanner")
    public Result updateBanner(@RequestBody BannerPO banner) {
        return Result.success(afBannerService.updateBanner(banner));
    }

    @GetMapping("/deleteBanner")
    public Result deleteBanner(@RequestParam("baId")Integer baId) {
        return Result.success(afBannerService.deleteBanner(baId));
    }

}
