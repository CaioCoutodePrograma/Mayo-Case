package com.Case.MayoCase.Util.Messages;

import com.Case.MayoCase.Exceptions.BusinessException;
import com.Case.MayoCase.Model.SellerModel;

import java.util.HashSet;
import java.util.Set;

public class MergeSets {
    public Set<SellerModel> mergeSellersSet(Set<SellerModel> sellerModelSet0, Set<SellerModel> sellerModelSet1){
        Set<SellerModel> mergedSet = new HashSet<>();
        mergedSet.addAll(sellerModelSet0);
        mergedSet.addAll(sellerModelSet1);
        if (sellerModelSet1.equals(sellerModelSet0)){
            throw new BusinessException(SellerMessageUtils.SELLER_ALREADY_LINKED);
        }
        return mergedSet;
    }
}
