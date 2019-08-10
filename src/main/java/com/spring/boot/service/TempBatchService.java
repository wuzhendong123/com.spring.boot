package com.spring.boot.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.TempBatch;
import com.baomidou.mybatisplus.service.IService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * <p>
 * 临时批次 服务类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-04-24
 */
public interface TempBatchService extends IService<TempBatch> {
        Page<TempBatch> selectPageByTempBatch(Page<TempBatch> pagePg, TempBatch obj);

        void createTempByRequest(HttpServletRequest request) throws IOException;
}
