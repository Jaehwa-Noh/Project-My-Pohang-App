//
//  Recommend.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

struct Recommend: Identifiable {
    let categoryType: CategoryType
    let name: String
    let location: String
    let information: String
    let source: String = "한국관광공사"
    let picture: String
    
    var id: String {
        categoryType.rawValue + name
    }
}
