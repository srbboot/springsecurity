package com.thc.spradv2025fall.service.impl;

import com.thc.spradv2025fall.domain.Chattalk;
import com.thc.spradv2025fall.domain.Chatuser;
import com.thc.spradv2025fall.dto.ChattalkDto;
import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.mapper.ChattalkMapper;
import com.thc.spradv2025fall.repository.ChatRepository;
import com.thc.spradv2025fall.repository.ChattalkRepository;
import com.thc.spradv2025fall.repository.ChatuserRepository;
import com.thc.spradv2025fall.service.ChattalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChattalkServiceImpl implements ChattalkService {

    final ChattalkRepository chattalkRepository;
    final ChattalkMapper chattalkMapper;
    final ChatRepository chatRepository;
    final ChatuserRepository chatuserRepository;

    /**/

    @Override
    public DefaultDto.CreateResDto create(ChattalkDto.CreateReqDto param) {
        return chattalkRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(ChattalkDto.UpdateReqDto param) {
        Chattalk chattalk = chattalkRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ chattalk.setDeleted(param.getDeleted()); }
        chattalkRepository.save(chattalk);
    }

    @Override
    public void delete(ChattalkDto.UpdateReqDto param) {
        update(ChattalkDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public ChattalkDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        ChattalkDto.DetailResDto res = chattalkMapper.detail(param);
        return res;
    }

    @Override
    public ChattalkDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<ChattalkDto.DetailResDto> list(ChattalkDto.ListReqDto param) {
        return addList(chattalkMapper.list(param));
    }

    public List<ChattalkDto.DetailResDto> addList(List<ChattalkDto.DetailResDto> list) {
        List<ChattalkDto.DetailResDto> returnList = new ArrayList<>();
        for(ChattalkDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return returnList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(ChattalkDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(chattalkMapper.pagedListCount(param));
        res.setList(addList(chattalkMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<ChattalkDto.DetailResDto> scrollList(ChattalkDto.ScrollListReqDto param) {
        Long myChatuserId = param.getMyChatuserId();

        Chatuser chatuser = chatuserRepository.findById(myChatuserId).orElseThrow(() -> new RuntimeException("no data"));
        Long chatId = chatuser.getChatId();
        param.setChatId(chatId);

        param.init();

        return addList(chattalkMapper.scrollList(param));
    }
}
