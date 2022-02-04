package com.glanner.api.service;

import com.glanner.api.dto.request.*;

public interface GlannerService {

    public void saveGlanner(String hostEmail);
    public void deleteGlanner(Long id);
    public void addUser(AddUserToGlannerReqDto reqDto, String hostEmail);
    public void deleteUser(Long glannerId, Long userId);
    public void addDailyWork(AddGlannerWorkReqDto reqDto);
    public void deleteDailyWork(Long glannerId, Long workId);
    public void updateDailyWork(UpdateGlannerWorkReqDto reqDto);

}