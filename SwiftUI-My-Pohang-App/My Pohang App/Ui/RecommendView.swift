//
//  RecommendView.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import SwiftUI

struct RecommendView: View {
    var category: Category?
    
    
    
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

#Preview {
    RecommendView(category: CategoryAndRecommendRepository().categories[0])
}
