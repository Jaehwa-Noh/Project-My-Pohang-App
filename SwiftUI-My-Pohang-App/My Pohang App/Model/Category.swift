//
//  Category.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import Foundation

struct Category: Identifiable {
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
