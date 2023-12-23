//
//  RecommendViewModel.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import Foundation

class RecommendListViewModel {
    var selectedCategory: Category?
    var recommends: [Recommend] = []
    var selectedRecommend: Recommend?
    
    func setSelectedCategory(category: Category) {
        selectedCategory = category
        recommends = getRecommendFromRepository(category: category)
    }
    
    private func getRecommendFromRepository(category: Category) -> [Recommend] {
        CategoryAndRecommendRepository().recommends.filter {
            $0.categoryType == category.category
        }
    }
}
