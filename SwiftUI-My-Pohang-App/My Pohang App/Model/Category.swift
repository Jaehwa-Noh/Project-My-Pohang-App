//
//  Category.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

struct Category: Identifiable, Equatable {
    let category: CategoryType
    var categoryName: String {
        category.rawValue
    }
    var iconName: String {
        category.getIcon()
    }
    
    var id: String {
        category.rawValue
    }
}
