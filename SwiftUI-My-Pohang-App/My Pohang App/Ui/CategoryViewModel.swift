//
//  CategoryViewModel.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import Foundation

class CategoryViewModel: ObservableObject {
    var categories: [Category]
    var selectedCategory: Category? = nil
    
    init() {
        self.categories = CategoryAndRecommendRepository().categories
    }
    
    func selectCategory(category: Category) {
        selectedCategory = category
    }
    
    func clearCategory() {
        selectedCategory = nil
    }
}
