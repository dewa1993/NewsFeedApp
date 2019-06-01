package com.upadhyay.newsfeedapplication.viewmodel.introduction;

import com.upadhyay.newsfeedapplication.base.viewmodel.AbstractViewModel;
import com.upadhyay.newsfeedapplication.repository.introduction.IntroductionRepositoryImpl;
import com.upadhyay.newsfeedapplication.repository.introduction.IntroductionRepository;
import com.upadhyay.newsfeedapplication.ui.introduction.contract.IntroductionContract;

import javax.inject.Inject;

public class IntroductionViewModel extends AbstractViewModel<IntroductionContract> implements IntroductionContract {

    private IntroductionRepository introductionRepository;

    @Inject
    IntroductionViewModel(IntroductionRepositoryImpl introductionRepository) {
        this.introductionRepository = introductionRepository;
    }

    @Override
    public IntroductionContract getViewModel() {
        return this;
    }
}

