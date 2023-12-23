//
//  CategoryViewModel.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import Foundation

class CategoryViewModel {
    var categories: [Category]
    
    init() {
        self.categories = CategoryAndRecommendRepository().categories
    }
}
