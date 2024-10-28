package zl.readCloud.service.front;


import zl.readCloud.controller.after.dto.BookChapterDTO;

import java.util.List;

/**
 * @Author：ZhangLei
 */
public interface FrReadingService {


    /**
     * detail: 精确查询一章
     * @param bId
     * @param cTitle
     * @return List<VoBookChapter>
     */
    List<BookChapterDTO> showReadingChapter(Integer bId, String cTitle);

    /**
     * detail: 查询上一章或下一章
     *          动态sql，根据参数（compare），为空 max(t.eTime) <
     *                                    不为空min(t.eTime) >
     * @param bId
     * @param eTime
     * @param compare
     * @return List<VoBookChapter>
     */
    List<BookChapterDTO> showNextOrPrevious(Integer bId, String eTime, String compare);
}
