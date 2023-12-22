//
//  RecommendView.swift
//  My Pohang App
//
//  Created by Jaehwa Noh on 12/22/23.
//

import SwiftUI

struct RecommendListView: View {
    var category: Category
    private var recommendListViewModel: RecommendListViewModel
    
    init(category: Category) {
        self.category = category
        self.recommendListViewModel = RecommendListViewModel()
        recommendListViewModel.setSelectedCategory(category: category)
    }
    
    var body: some View {
        ZStack {
            ScrollView {
                LazyVStack(alignment: .leading) {
                    ForEach(recommendListViewModel.recommends) {
                        recommend in
                        RecommendListItem(recommend: recommend)
                    }
                }
                .padding(8)
            }
            
        }
    }
}

struct RecommendListItem: View {
    var recommend: Recommend
    var body: some View {
        HStack(alignment: .center, spacing: 8) {
            Image(recommend.picture)
                .resizable()
                .scaledToFill()
                .frame(width: 125, height:125)
                .clipped()
            
            Text("\(recommend.name)")
                .font(.title)
        }
    }
}

#Preview {
    RecommendListView(category: CategoryAndRecommendRepository().categories[0])
}
