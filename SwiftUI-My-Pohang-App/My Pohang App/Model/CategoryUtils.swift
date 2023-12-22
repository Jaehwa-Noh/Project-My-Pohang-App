//
//  CategoryUtils.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import Foundation

enum CategoryType: String {
    case coffeeShop = "카페"
    case restaurants = "식당"
    case kidFriendly = "아이와 함께"
    case parks = "공원"
    case shoppingCenters = "쇼핑"
}

extension CategoryType {
    func getIcon() -> String {
        switch self {
        case .coffeeShop:
            "mug.fill"
        case .restaurants:
            "fork.knife"
        case .kidFriendly:
            "figure.2.and.child.holdinghands"
        case .parks:
            "tree.fill"
        case .shoppingCenters:
            "bag"
        }
    }
}
