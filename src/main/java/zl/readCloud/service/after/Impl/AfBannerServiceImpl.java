package zl.readCloud.service.after.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zl.readCloud.dao.BannerDao;
import zl.readCloud.controller.after.dto.BannerDTO;
import zl.readCloud.pojo.BannerPO;
import zl.readCloud.service.after.AfBannerService;

import java.util.List;

/**
 * @author ZhangLei
 * @Description:
 * @date 2021/10/14 11:20
 */
@Service
public class AfBannerServiceImpl implements AfBannerService {

    @Autowired
    private BannerDao bannerDao;


    @Override
    public List<BannerDTO> getBannerList(Integer pages, Integer limit) {
        return bannerDao.getBannerList(pages, limit);
    }

    @Override
    public Integer getBannerListCount() {
        return bannerDao.getBannerListCount();
    }

    @Override
    public int addBanner(BannerPO banner) {
        return bannerDao.addBanner(banner);
    }

    @Override
    public int updateBanner(BannerPO banner) {
        return bannerDao.updateBanner(banner);
    }

    @Override
    public int deleteBanner(int baId) {
        return bannerDao.deleteBanner(baId);
    }


}
